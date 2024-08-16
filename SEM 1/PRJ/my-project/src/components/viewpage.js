import React from "react";
import jsonData from "../data.json";
const viewpage = (props) => {
  const viewpageId = parseInt(this.props.match.params.id);
  const viewpage = jsonData.viewpage.find((item) => item.id === viewpageId);

  if (!viewpage) {
    return <div>Bài báo không tồn tại</div>;
  }

  return (
    <div>
      <h2>{viewpage.title}</h2>
      <div className="images">
        {viewpage.images.map((image, index) => (
          <img key={index} src={image} alt={`Image ${index}`} />
        ))}
      </div>
    </div>
  );
};

export default viewpage;
