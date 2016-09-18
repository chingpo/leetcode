package ps;

/*
 * 这是百度知道里面的一个问题:我觉得不错,自己也运行修改了一下,就发布一下以后备用.
 * 题目:java 按行读取txt文件的数字
 * 文件file4.txt中（数据是按行排列的，每行一个数值）
 * 1234
 * 90.7
 * 78.8
 * 4567
 * 87.3
 * 65.6
 *现在要建立一个数组double类型，把file4中所有的数字都写入到这个数组中，请问该怎么编写，谢谢。
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File2
{
	public static double[] writeToDat(String path)
	{
		File file = new File(path);
		List<String> list = new ArrayList<String>();
		double[] nums = null;
		try
		{
			BufferedReader bw = new BufferedReader(new FileReader(file));
			String line = null;
			// 因为不知道有几行数据，所以先存入list集合中
			while ((line = bw.readLine()) != null)
			{
				list.add(line);
			}
			bw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 确定数组长度
		nums = new double[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);
			nums[i] = Double.parseDouble(s);
		}
		return nums;
	}

	public static void main(String[] args)
	{

		String path = "f:/file4.txt";
		double[] nums = writeToDat(path);
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
