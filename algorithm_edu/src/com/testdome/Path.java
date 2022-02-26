package com.testdome;

import java.util.LinkedList;
import java.util.Arrays;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    private LinkedList<String> listFolders() {
        String[] folder = this.path.split("/");
        
        LinkedList<String> folderList = new LinkedList(Arrays.asList(folder));
        
        return folderList;
    }

    public void cd(String newPath) {
        if (newPath == "")
            return;
        
        LinkedList<String> folderList = this.listFolders();
        
        String[] paths = newPath.split("/");
        
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(""))
                continue;
            
            if (paths[i].equals("..") && folderList.size() >= 1)
                folderList.removeLast();
            else
                folderList.addLast(paths[i]);    
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String folder : folderList) {
            if (!folder.equals("")) {
               sb.append("/");
                sb.append(folder); 
            }
        }
        this.path = sb.toString();
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
