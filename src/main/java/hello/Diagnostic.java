package hello;

public class Diagnostic {

	public static String getStackTraceString(String title) {
		
		StringBuffer sb = new StringBuffer("");
		sb.append("\n* * * * * * * * INICIO StackTrace " + title
				+ " * * * * * * * * * * \n");
		StackTraceElement e[] = Thread.currentThread().getStackTrace();
		for (int i = 0; i < e.length; i++) {
			if (!(e[i].toString().startsWith(
					"br.cepel.util.Diagnostic.getStackTraceString") || e[i].toString()
					.startsWith("java.lang.Thread.getStackTrace"))) {
				sb.append(e[i] + "\n");
			}
		}
		sb.append("* * * * * * * * FIM StackTrace   " + title
				+ " * * * * * * * * * * \n");

		return sb.toString();
	}
}
