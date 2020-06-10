package edu.hanu.dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hanu.model.Comment;

public class CommentDAO {
	private Client client = ClientBuilder.newClient();
	private final WebTarget baseTarget = client
			.target("http://localhost:8080/social-media-platform/webapi/posts/{post_id}");
	private WebTarget resourceTarget = baseTarget.path("/{resourceName}");
	private WebTarget resourceTargetId;

	public CommentDAO() {
		resourceTargetId = resourceTarget.path("/{resourceId}");
	}

	public Comment get(long id, long postId) {
		Comment comment = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("post_id", postId).resolveTemplate("resourceId", id)
				.request(MediaType.APPLICATION_JSON).get(Comment.class);
		return comment;
	}

	public void save(Comment comment) {
		Response response = resourceTarget.resolveTemplate("post_id", comment.getPost().getId())
				.resolveTemplate("resourceName", "comments").request().post(Entity.json(comment));
		if (response.getStatus() != 201) {
			System.err.println("CommentDAO.save");
		}
	}

	public List<Comment> getAll(long postId) {
		List<Comment> response = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("post_id", postId).request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Comment>>() {
				});
		return response;
	}

	public void update(Comment comment) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("post_id", comment.getPost().getId()).resolveTemplate("resourceId", comment.getId())
				.request().put(Entity.json(comment));
		if (response.getStatus() != 204) {
			System.err.println("CommentDAO.update()");
		}
	}

	public void delete(long id, long postId) {
		Response response = resourceTargetId.resolveTemplate("resourceName", "comments")
				.resolveTemplate("post_id", postId).resolveTemplate("resourceId", id).request().delete();
		if (response.getStatus() != 204) {
			System.err.println("CommentDAO.delete()");
		}
	}

	public static void main(String[] args) {
		CommentDAO dao = new CommentDAO();
		System.out.println(dao.get(7, 6));
	}
}
