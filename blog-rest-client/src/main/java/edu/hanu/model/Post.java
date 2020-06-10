package edu.hanu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Post {
	private long id;
	private String title;
	private String content;
	private List<Link> links = new ArrayList<>();
	
	public Post(long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Post() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void addLink(String uri, String rel) {
		Link link = new Link();
		link.setUri(uri);
		link.setRel(rel);
		links.add(link);	
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

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", links=" + links.toString() + "]";
	}
	
}
