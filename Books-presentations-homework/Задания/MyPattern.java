import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPattern {
	public static final String NAT_PATTERN = "\\d+"; 
	public static final String INT_PATTERN = "(-)?\\d+";
	public static final String DAY_PATTERN = "(���|���|���)(([�-�])*)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(DAY_PATTERN);
		if (p.matches(DAY_PATTERN, "���"))
		{
			System.out.println("yes");
		}
		else
			System.out.println("No");
		
		Matcher m = p.matcher("������� �������, � � ����������� ������� ����(����)");
		while (m.find())
		{
			System.out.println(m.group());
		}
			

	}

}
