package co.kr.programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
    문제 설명
    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
    
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
    
    제한사항
    genres[i]는 고유번호가 i인 노래의 장르입니다.
    plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
    genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    장르 종류는 100개 미만입니다.
    장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    모든 장르는 재생된 횟수가 다릅니다.
    입출력 예
    genres  plays   return
    ["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500]  [4, 1, 3, 0]
    입출력 예 설명
    classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
    
    고유 번호 3: 800회 재생
    고유 번호 0: 500회 재생
    고유 번호 2: 150회 재생
    pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
    
    고유 번호 4: 2,500회 재생
    고유 번호 1: 600회 재생
    따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
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

// 리스트에 저장될 클래스 입니다.
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