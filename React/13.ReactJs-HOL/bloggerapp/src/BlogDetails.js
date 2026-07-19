import React from "react";

function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Stephen Biz",
      description: "Welcome to learning React!"
    },
    {
      id: 2,
      title: "Installation",
      author: "Schwzdenier",
      description: "You can install React from npm."
    }
  ];

  const content = (
    <ul>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h2>{blog.title}</h2>
          <h4>{blog.author}</h4>
          <p>{blog.description}</p>
          <br />
        </div>
      ))}
    </ul>
  );

  return (
    <div className="column">
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}

export default BlogDetails;