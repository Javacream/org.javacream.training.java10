package org.javacream.training.java10.helloworld.dao.api.data;


public class HelloWorldResponse {

	private String message;

	@Override
	public String toString() {
		return "HelloWorldResponse [message=" + message + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HelloWorldResponse other = (HelloWorldResponse) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	public HelloWorldResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
