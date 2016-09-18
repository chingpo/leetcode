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

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
public class File3  
{  
    public static void main(String[] args)  
    {  
        // 传入参数为文件目录  
        GetDataProcess("f:/a.txt");  
    }  
  
    public static void GetDataProcess(String filePath)  
    {  
        BufferedReader br = null;  
        try  
        {  
            br = new BufferedReader(new FileReader(filePath));  
        } catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
            return;  
        }  
  
        String[] columnName =  
        { "Id", "Name", "Languages", "Math", "English" }; // 列名  
        int[] courseIndexs =  
        { 2, 3, 4 }; // 课程对应的列  
        int i, j, index;  
        String line;  
        List<Map<String, Object>> students = new ArrayList<Map<String, Object>>();  
        // 记录Id和总值,用于排序  
        List<Map<String, Object>> sortList = new ArrayList<Map<String, Object>>();  
        try  
        {  
            br.readLine(); // 去掉第一行  
            while ((line = br.readLine()) != null)  
            {  
                index = 0;  
                String[] se = line.split(" ");  
                Map<String, Object> student = new HashMap<String, Object>();  
                for (i = 0; i < se.length; i++)  
                {  
                    if ("".equals(se[i]))  
                    {  
                        continue;  
                    }  
                    if (index >= columnName.length)  
                    {  
                        continue;  
                    }  
                    student.put(columnName[index], se[i]);  
                    index++;  
                }  
                // 计算平均值,总值  
                double total = 0;  
                for (j = 0; j < courseIndexs.length; j++)  
                {  
                    total += Double.parseDouble((String) student  
                            .get(columnName[courseIndexs[j]]));  
                }  
                double average = total / courseIndexs.length;  
                // 只取一位小数  
                average = Math.round(average * 10) / 10;  
                student.put("Total", total);  
                student.put("Average", average);  
  
                Map<String, Object> sort = new HashMap<String, Object>();  
                sort.put("Id", student.get("Id"));  
                sort.put("Total", student.get("Total"));  
                sortList.add(sort);  
  
                students.add(student);  
            }  
            br.close();  
  
            // 排序  
            for (i = 0; i < sortList.size(); i++)  
            {  
                for (j = i + 1; j < sortList.size(); j++)  
                {  
                    if ((Double) sortList.get(i).get("Total") < (Double) sortList  
                            .get(j).get("Total"))  
                    {  
                        Map<String, Object> temp = sortList.get(i);  
                        sortList.set(i, sortList.get(j));  
                        sortList.set(j, temp);  
                    }  
                }  
            }  
            Map<Object, Integer> sortedId = new HashMap<Object, Integer>();  
            for (i = 0; i < sortList.size(); i++)  
            {  
                sortedId.put(sortList.get(i).get("Id"), i + 1);  
            }  
  
            // 设定序号  
            for (j = 0; j < students.size(); j++)  
            {  
                students.get(j).put("Order",  
                        sortedId.get(students.get(j).get("Id")));  
            }  
  
            // 输出(写到原文件)  
            // PrintWriter pw = new PrintWriter(new File(filePath));  
            // 输出(写到其他文件)  
            PrintWriter pw = new PrintWriter(new File("f:/b.txt"));  
  
            pw.println("Id\tName\tLan\tMath\tEnglish\tAverage\tTotal\tSort");  
            int cIndex;  
            for (i = 0; i < students.size(); i++)  
            {  
                Map<String, Object> st = students.get(i);  
                cIndex = 0;  
                pw.println(st.get(columnName[cIndex++]) + "\t"  
                        + st.get(columnName[cIndex++]) + "\t"  
                        + st.get(columnName[cIndex++]) + "\t"  
                        + st.get(columnName[cIndex++]) + "\t"  
                        + st.get(columnName[cIndex++]) + "\t" + st.get("Total")  
                        + "\t" + st.get("Average") + "\t" + st.get("Order"));  
            }  
            pw.flush();  
            pw.close();  
        } catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
    }
}