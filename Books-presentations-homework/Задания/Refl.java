import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Refl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class a = Class.forName("java.lang.Math");
			System.out.println("Methods:");
			Method m[] = a.getDeclaredMethods();
			for (Method i : m)
				System.out.println(i);
			System.out.println();
			System.out.println("Fields:");
			Field f[] = a.getDeclaredFields();
			for (Field i : f)
				System.out.println(i);
			System.out.println();

			Method methSin = a.getMethod("sin", double.class);
			System.out.println("Result sin ="+methSin.invoke(null, -Math.PI/6));
			
			Class b = Class.forName("java.lang.String");
			Method methConcat = b.getMethod("concat", String.class);
			Object str = b.newInstance();
			System.out.println("Result concat ="+methConcat.invoke(str, "-Math.PI/6"));
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
