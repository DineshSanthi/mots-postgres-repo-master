package solutions.mots.repo.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
	
	public static String MESSAGES = "messages";
	
	public static ResourceBundle getBundle(String resourceName, Locale locale) {
		return ResourceBundle.getBundle(resourceName, locale);
	}

	public static String getBundleForLocale(String resourceName, String key, Locale locale) {
		ResourceBundle bundle = getBundle(resourceName, locale);
		String message = "";
		try 
		{
			message = bundle.getString(key);	
		}
		catch (Exception e) 
		{
			message = "Couldn't find message for the given key: " + key;
		}
		return message;
	}
	
	public static String getMessage(String key) {
		return getBundleForLocale(MESSAGES, key, Locale.getDefault());
	}
	
	public static String getMessage(String key, Object... args) {
		MessageFormat formatter = new MessageFormat(getMessage(key));
		return formatter.format(args);
	}
	
}
