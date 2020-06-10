package edu.hanu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	private long id;
	private String comment;
	private Post post;
	private List<Link> links = new ArrayList<>();
	
	public Comment(long id, String comment, Post post) {
		super();
		this.id = id;
		this.comment = comment;
		this.post = post;
	}

	public Comment() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String uri, String rel) {
		Link link = new Link();
		link.setUri(uri);
		link.setRel(rel);
		links.add(link);	
	}
}
