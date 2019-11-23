/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import Domain.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    
    
    public List<Post> getPostsByThread(int threadId) {
        

        List<Post> posts = HibernateHelper.getListData(Post.class);
        List<Post> postsByThread = new ArrayList<>();
        
        for (Post p : posts) {
            if (p.getThread().getThreadId() == threadId) {
                postsByThread.add(p);
            }
        }
        
        return postsByThread;
    }
}
