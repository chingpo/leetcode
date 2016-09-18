package ps;

/*Java文件操作：按行读取和写入

文件操作是任何语言中最为常用的部分，Java也不例外。这里主要介绍按行读取的文件操作和写入
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFile
{
public static void main(String[] args)
{
	try
	{
		// read file content from file
		StringBuffer sb = new StringBuffer("");

		FileReader reader = new FileReader("f://testRead.txt");
		BufferedReader br = new BufferedReader(reader);

		String str = null;

		while ((str = br.readLine()) != null)
		{
			sb.append(str + "\n");

			System.out.println(str);
		}

		br.close();
		reader.close();

		// write string to file
		FileWriter writer = new FileWriter("f://testWrite.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(sb.toString());

		bw.close();
		writer.close();
	} catch (FileNotFoundException e)
	{
		e.printStackTrace();
	} catch (IOException e)
	{
		e.printStackTrace();
	}
}

}
