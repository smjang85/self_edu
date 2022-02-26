package com.test.case4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/*
John likes to travel. He has visited a lot of cities over many years.

Note that. in some rare cases, photos from different locations may share the time and date,
due to timezone differences.

as there are ten photos taken in Warsaw(numbered from 01 to 10), two photos in London
 */
class Photo {
	String time;
	String city;
	String cnt;
	String extension;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
}

public class SortPhoto {
	
	
	public static String solution(String S) {
        // write your code in Java SE 8
		StringBuffer result = new StringBuffer();
		
		
		String separator = System.getProperty("line.separator");
		String[] strArr = S.split(separator);
		
		ArrayList orgList = new ArrayList();
		for(int i = 0; i < strArr.length; i++) {
			Photo photo = new Photo();
			String[] line = strArr[i].split(",");
			
			String fileName = line[0].trim();
			String extension = fileName.split("[.]")[1];
			String city = line[1].trim();
			String time = line[2].trim();
			time = time.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "").trim();
			
			photo.setExtension(extension);
			photo.setCity(city);
			photo.setTime(time);
			orgList.add(photo);
		}
		ArrayList list = (ArrayList) orgList.clone();
		
        Collections.sort(list, new Comparator<Photo>() {
            @Override
            public int compare(Photo s1, Photo s2) {
                if (Long.parseLong(s1.getTime()) < Long.parseLong(s2.getTime())) {
                    return -1;
                } else if (Long.parseLong(s1.getTime()) > Long.parseLong(s2.getTime())) {
                    return 1;
                }
                return 0;
            }
        });

        HashMap<String, Integer> cntMap = new HashMap();
		for(int i = 0; i <list.size(); i++) {
			Photo photo = (Photo) list.get(i);
			String city = photo.getCity();
			Integer cnt = 0;
			if(cntMap.get(city) != null) {
				Integer beforeCnt = cntMap.get(city);
				cnt = beforeCnt + 1;
			}else {
				cnt = 1;
			}
			cntMap.put(city, cnt);
			photo.setCnt(cnt.toString());
			
			/*
			result.append(photo.getCity() + "." + photo.getExtension() + "." +photo.getTime() + "." + cnt);
			if(i != list.size() -1) {
				result.append(System.getProperty("line.separator"));
			}
			*/
		}
		
		for(int i = 0; i <orgList.size(); i++) {
			Photo photo = (Photo) orgList.get(i);
			String city1 = photo.getCity();
			String time1 = photo.getTime();
			for(int j = 0; j < list.size(); j++) {
				Photo photo2 = (Photo) list.get(j);
				String city2 = photo2.getCity();
				String time2 = photo2.getTime();
				
				cntMap.get(city2);
				
				
				
				if(city1.equals(city2) && time1.equals(time2)) {
					
					String cnt = cntMap.get(city2).toString();
					String format = "%0" + cnt.length()+ "d";
					
					photo.setCnt(String.format(format, Integer.parseInt(photo2.getCnt())));
				}
			}
		}
		
		for(int i = 0; i < orgList.size(); i++) {
			Photo photo = (Photo) orgList.get(i);
			
			result.append(photo.getCity() + photo.getCnt() + "." + photo.getExtension());
			if(i != list.size() -1) {
				result.append(System.getProperty("line.separator"));
			}
			
		}
		
		return  result.toString();
    }
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer();
		data.append("photo.jpCompilation successful.\r\n" + 
				"Compiler output:\r\n" + 
				"Note: Solution.java uses unchecked or unsafe operations.\r\n" + 
				"Note: Recompile with -Xlint:unchecked for details.\r\n" + 
				"\r\n" + 
				"Example test:    'photo.jpg, Warsaw, 2013-09-05 14:08:15\\njohn.png, London, 2015-06-20 15:13:22\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\nBOB.jpg, London, 2015-08-05 00:02:03\\nnotredame.png, Paris, 2015-09-01 12:00:00\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\na.png, Warsaw, 2016-02-13 13:33:50\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\\nf.png, Warsaw, 2016-01-02 10:55:32\\ng.jpg, Warsaw, 2016-02-29 22:13:11' g, Warsaw, 2013-09-05 14:08:15");
		data.append(System.getProperty("line.separator"));
		data.append("john.png, London, 2015-06-20 15:13:22");
		data.append(System.getProperty("line.separator"));
		data.append("myFriends.png, Warsaw, 2013-09-05 14:07:13");
		data.append(System.getProperty("line.separator"));
		data.append("Eiffel.jpg, Paris, 2015-07-23 08:03:02");
		data.append(System.getProperty("line.separator"));
		data.append("pisatower.jpg, Paris, 2015-07-22 23:59:59");
		data.append(System.getProperty("line.separator"));
		data.append("BOB.jpg, London, 2015-08-05 00:02:03");
		data.append(System.getProperty("line.separator"));
		data.append("notredame.png, Paris, 2015-09-01 12:00:00");
		data.append(System.getProperty("line.separator"));
		data.append("me.jpg, Warsaw, 2013-09-06 15:40:22");
		data.append(System.getProperty("line.separator"));
		data.append("a.png, Warsaw, 2016-02-13 13:33:50");
		data.append(System.getProperty("line.separator"));
		data.append("b.jpg, Warsaw, 2016-01-02 15:12:22");
		data.append(System.getProperty("line.separator"));
		data.append("c.jpg, Warsaw, 2016-01-02 14:34:30");
		data.append(System.getProperty("line.separator"));
		data.append("d.jpg, Warsaw, 2016-01-02 15:15:01");
		data.append(System.getProperty("line.separator"));
		data.append("e.png, Warsaw, 2016-01-02 09:49:09");
		data.append(System.getProperty("line.separator"));
		data.append("f.png, Warsaw, 2016-01-02 10:55:32");
		data.append(System.getProperty("line.separator"));
		data.append("g.jpg, Warsaw, 2016-02-29 22:13:11");
		data.append(System.getProperty("line.separator"));
		
		System.out.println(solution(data.toString()));
	}

}
