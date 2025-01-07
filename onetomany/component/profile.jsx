import React, { useState } from "react";
import "./profile.css";
import { Button } from "@mui/material";

function Profile() {
  const [name, setName] = useState();

  return (
    <div>
      <div className="alignn">
        <br />
        <div className="center">
          <i className="fa-solid fa-user fa-3xl" id="id1"></i>
          <br />
          <br />
          <h2>General Information</h2>
          <br />
          <div className="lll">
            <div>
              <h3> Name:</h3>
              <br />
              <div>
                <p>Mani Kannan</p>
              </div>
            </div>
            <div className="lll">
              <h3>User:</h3>
              <p>Manikannan@gmail.com</p>
              <label>
                <h3>Gender:</h3>
              </label>
              <p>Male</p>
              <h3>Contact No:</h3>
              <p>9843249607</p>
              <Button color="warning" className="but">
                Save
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Profile;
