package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link {
	private String uri; //dg dan
	private String rel; //lien quan
	
	public Link(String uri, String rel) {
		super();
		this.uri = uri;
		this.rel = rel;
	}

	public Link() {
		super();
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the rel
	 */
	public String getRel() {
		return rel;
	}

	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		return "Link [uri=" + uri + ", rel=" + rel + "]";
	}
}
