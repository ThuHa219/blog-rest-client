package edu.hanu.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.model.Post;

public class PostDAO {
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client.target("http://localhost:8080/social-media-platform/webapi");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public PostDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public Post get(long id) {
		Post post = resourceTargetId.resolveTemplate("resourceName", "posts")
				.resolveTemplate("resourceId", id).request(MediaType.APPLICATION_JSON).get(Post.class);
		return post;
	}

	public void save(Post post) {
		Response response = resourceTarget.resolveTemplate("resourceName", "posts").request()
				.post(Entity.json(post));
		if (response.getStatus() != 201) {
			System.err.println("PostDAO.save");
		}
	}
	
	public List<Post> getAll() {
		List<Post> response = resourceTarget.resolveTemplate("resourceName", "posts")
												.request(MediaType.APPLICATION_JSON)
												.get(new GenericType<List<Post>>() {});
		return response;
	}
	
	public void update(Post post) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "posts")
				.resolveTemplate("resourceId", post.getId())
				.request()
				.put(Entity.json(post));
		if (response.getStatus() != 204) {
			System.err.println("PostDAO.update()");
		}
	}
	
	public void delete(long id) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "posts")
				.resolveTemplate("resourceId", id)
				.request()
				.delete();
		if (response.getStatus() != 204) {
			System.err.println("PostDAO.delete()");
		}
	}
	public static void main(String[] args) {
		PostDAO dao = new PostDAO();
		System.out.println(dao.get(6).toString());
		
	}
}
