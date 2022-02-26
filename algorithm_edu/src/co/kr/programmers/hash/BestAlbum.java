package co.kr.programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
    ���� ����
    ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
    
    ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
    �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
    �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
    �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
    
    ���ѻ���
    genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
    plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
    genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
    �帣 ������ 100�� �̸��Դϴ�.
    �帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
    ��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
    ����� ��
    genres  plays   return
    ["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500]  [4, 1, 3, 0]
    ����� �� ����
    classic �帣�� 1,450ȸ ����Ǿ�����, classic �뷡�� ������ �����ϴ�.
    
    ���� ��ȣ 3: 800ȸ ���
    ���� ��ȣ 0: 500ȸ ���
    ���� ��ȣ 2: 150ȸ ���
    pop �帣�� 3,100ȸ ����Ǿ�����, pop �뷡�� ������ �����ϴ�.
    
    ���� ��ȣ 4: 2,500ȸ ���
    ���� ��ȣ 1: 600ȸ ���
    ���� pop �帣�� [4, 1]�� �뷡�� ����, classic �帣�� [3, 0]�� �뷡�� �״����� �����մϴ�.
 */
public class BestAlbum {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		ArrayList<GenreChart> genresList = new ArrayList<GenreChart>();
		HashMap<String,GenreChart> genresData = new HashMap<String,GenreChart>();
		GenreChart chart = null;
		for (int i = 0; i < genres.length; i++) {
			if(null == genresData.get(genres[i])) {
				chart = new GenreChart();
				chart.setGenres(genres[i]);
			}else {
				chart = genresData.get(genres[i]);
			}
			int total = chart.getTotal() + plays[i];
			
			chart.setTotal(total);
			
			int currentBestPlays = chart.getBestPlays();
			int currentSecondPlays = chart.getSecondPlays();
			
			if(plays[i] > currentBestPlays) {
				chart.setSecondPlays(currentBestPlays);
				chart.setSecondPlaysLoc(chart.getBestPlaysLoc());
				
				chart.setBestPlays(plays[i]);
				chart.setBestPlaysLoc(i);
			}else {
				if(plays[i] > currentSecondPlays) {
					chart.setSecondPlays(plays[i]);
					chart.setSecondPlaysLoc(i);
				}
			}
			genresData.put(genres[i],chart);
		}
		
	    Iterator<String> iter = genresData.keySet().iterator();
	    while (iter.hasNext()) {
	        String keys = (String) iter.next();
	        genresList.add(genresData.get(keys));
	    }

	    Collections.sort(genresList);
	    
	    ArrayList<Integer> chartLoc = new ArrayList<Integer>();
	    for(GenreChart data : genresList) {
	    	chartLoc.add(data.getBestPlaysLoc());
	    	if(data.getSecondPlaysLoc() != -1) {
	    		chartLoc.add(data.getSecondPlaysLoc());	
	    	}
	    }

	    	
		return convertIntegers(chartLoc);
	}

	public int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	
	/*public static void main(String[] args) throws Exception {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = solution(genres, plays);
		for(int i = 0 ; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}*/
}

// ����Ʈ�� ����� Ŭ���� �Դϴ�.
class GenreChart implements Comparable<GenreChart> {
	private String genres;
	private Integer total;
	private int bestPlays;
	private int bestPlaysLoc;
	private int secondPlays;
	private int secondPlaysLoc;
	
	public GenreChart() {
		this.total = 0;
		this.bestPlays = 0;
		this.secondPlays = 0;
		this.bestPlaysLoc = -1;
		this.secondPlaysLoc = -1;
	}

	public String getGenres() {
		return genres;
	}

	public Integer getTotal() {
		return total;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


	public int getBestPlays() {
		return bestPlays;
	}

	public void setBestPlays(int bestPlays) {
		this.bestPlays = bestPlays;
	}

	public int getBestPlaysLoc() {
		return bestPlaysLoc;
	}

	public void setBestPlaysLoc(int bestPlaysLoc) {
		this.bestPlaysLoc = bestPlaysLoc;
	}

	public int getSecondPlays() {
		return secondPlays;
	}

	public void setSecondPlays(int secondPlays) {
		this.secondPlays = secondPlays;
	}

	public int getSecondPlaysLoc() {
		return secondPlaysLoc;
	}

	public void setSecondPlaysLoc(int secondPlaysLoc) {
		this.secondPlaysLoc = secondPlaysLoc;
	}

	public int compareTo(GenreChart genreChart) {
		return genreChart.total.compareTo(this.total);
	}

	@Override
	public String toString() {
		return "GenreChart [genres=" + genres + ", total=" + total + ", bestPlays=" + bestPlays + ", bestPlaysLoc="
				+ bestPlaysLoc + ", secondPlays=" + secondPlays + ", secondPlaysLoc=" + secondPlaysLoc + "]";
	}
}