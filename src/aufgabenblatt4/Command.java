package aufgabenblatt4;

import java.util.regex.*;
public class Command {

	private PolygonModel executor;;
	private String ausdruck;
	Pattern pattern;
	Matcher matcher;
	public Command(PolygonModel model)
	{
		executor = model;
		ausdruck = "^bewege\\s->\\s\\d+([,]\\d*)?";
		pattern = Pattern.compile(ausdruck);
	}
	public void apply(String command)
	{
		
		matcher = pattern.matcher(command);
		if(matcher.matches())
		{
			double x;
			double y;
			String s[] = new String[2];
			String split[] =  command.split("[^0-9]");
			int j = 0;
			for(int i = 0;  i < split.length; i++)
			{
				if(!split[i].isEmpty())
				{
					s[j++] = split[i];
				}
			}
			x = Double.parseDouble(s[0]);
			y = Double.parseDouble(s[1]);
			executor.getCurrentPolygon().addPoint(new Point(x, y));
		}
		
		else 
		{
			System.out.println("Wrong Command, try Again with this pattern :");
			System.out.println("<Kommand> -> x,y");
		}
	}
}
