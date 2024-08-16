import { faFire } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import "./homepage.css";
import Navbar from "./navbar";
const Homepage = () => {
  return (
    <div>
      <Navbar />
      <div class="separator"></div>
      <div id="hot" className="container">
        <div className="list-1">
          <FontAwesomeIcon icon={faFire} style={{ color: "#e32400" }} />
          <span style={{ marginLeft: "5px" }}>HOT</span>
        </div>
        <div class="separator" style={{ height: "1px" }}></div>
        <div style={{ height: "470px" }}></div>
        <div class="separator" style={{ height: "1px" }}></div>
      </div>

      <div id="BreakingNews" className="container">
        <div className="list-2">
          <span
            style={{
              backgroundColor: "Red",
              color: "#FFF",
              padding: "5px 10px",
              fontSize: "20px",
            }}>
            Breaking News
          </span>
        </div>
        <div class="separator" style={{ backgroundColor: "red" }}></div>
        <div style={{ height: "470px" }}></div>
        <div class="separator" style={{ height: "1px" }}></div>
      </div>
    </div>
  );
};

export default Homepage;
