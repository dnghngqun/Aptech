import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import { NavLink } from "react-router-dom";
import "./navbar.css";
const navbar = () => {
  const activeNavBar = {
    fontWeight: "900",
  };
  return (
    <div id="header">
      <div className="left">
        <img src="logo.png" alt="logo" />
      </div>
      <div className="right">
        <div>
          <NavLink
            to="#"
            style={({ isActive }) => (isActive ? activeNavBar : {})}>
            Home
          </NavLink>
        </div>
        <div>
          <NavLink to="#">Today in World</NavLink>
        </div>
        <div>
          <NavLink to="#">Sports</NavLink>
        </div>
        <div>
          <NavLink to="#">Business</NavLink>
        </div>
        <div>
          <NavLink className="btn btn-success" to="#" style={{ color: "#fff" }}>
            Login
          </NavLink>
        </div>
      </div>
    </div>
  );
};

export default navbar;
