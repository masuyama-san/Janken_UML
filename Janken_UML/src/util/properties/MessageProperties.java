package util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;


public class MessageProperties {

	private static Properties properties;
	private final static String FILE = "util/properties/messages.properties";

	/**
	 * メッセージ取得処理
	 * @param resourceId
	 * @return
	 * @throws SystemException
	 */
	public static String getMessage(String resourceId) throws Exception {

		//プロパティファイル初期化処理
		MessageProperties.init();

		//パラメーターチェック resourceId
		if (resourceId == null || resourceId.isEmpty()) {
			throw new Exception(properties.getProperty("msg.error.argument"));
		}

		//メッセージ取得処理
		String msg = properties.getProperty(resourceId);

		//メッセージチェック処理
		if (msg == null) {
			throw new Exception(MessageFormat.format(properties.getProperty("error.nodata"), resourceId));
		}

		return msg;
	}

	/**
	 * メッセージ取得処理 フォーマット
	 * @param resourceId
	 * @param arguments
	 * @return
	 * @throws SystemException
	 */
	public static String getMessage(String resourceId, String... arguments) throws Exception {

		//プロパティファイル初期化処理
		MessageProperties.init();

		//パラメーターチェック resourceId,arguments
		if (resourceId == null || resourceId.isEmpty()
				|| arguments == null || arguments.length == 0) {

			throw new Exception(properties.getProperty("msg.error.argument"));
		}

		//メッセージ取得処理
		String msg = properties.getProperty(resourceId);

		//メッセージチェック処理
		if (msg == null) {
			throw new Exception(MessageFormat.format(properties.getProperty("error.nodata"), resourceId));
		}

		return MessageFormat.format(msg, (Object[]) arguments);
	}

	/**
	 * プロパティファイル読込処理
	 * @throws SystemException
	 */
	private static void init() throws Exception {

		try {

			if (properties == null) {
				properties = new Properties();
				InputStream is = MessageProperties.class.getClassLoader().getResourceAsStream(FILE);
				properties.load(new InputStreamReader(is,"UTF-8"));
			}

		} catch (IOException e) {
			//ファイルload処理を失敗した場合
			throw new Exception(properties.getProperty("msg.error.properties.load"));

		}
	}
}

