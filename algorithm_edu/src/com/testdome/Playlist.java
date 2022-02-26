package com.testdome;
import java.util.HashSet;
import java.util.Set;

public class Playlist {
    public static class Song {
        private String name;
        private Song nextSong;
 
        public Song(String name) {
            this.name = name;
        }
    
        public void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }
    
        public boolean isRepeatingPlaylist() {
        	boolean result = false;
            Set<String> songs = new HashSet();
            Song next_song = this;
            while(next_song != null) {
            	if(songs.contains(next_song.name)) {
            		return true;
                }else {
                	songs.add(next_song.name);
                	next_song = next_song.nextSong;
                }	
            }
            
            return result;
        }
    }
    
    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
    
        first.setNextSong(second);
        second.setNextSong(first);
    
        System.out.println(first.isRepeatingPlaylist());
    }
}