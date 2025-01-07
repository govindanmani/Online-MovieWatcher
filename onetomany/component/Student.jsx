import axios from "axios";
import React from "react";
import GetDetails from "./form";

const Student = () => {
  function fetchStudents() {
    axios.get("/api/students").then((res) => {
      console.log(res.data);
    });
  }

  function createStudents() {
    axios
      .post("/api/students", {
        id: 123,
        name: "Ramana Boy",
        department: "Btech IT",
      })
      .then((res) => {
        console.log(res.data);
      });
  }

  function get() {
    const a = GetDetails();
    console.log(a);
    axios.post("/movie", a);
  }

  return (
    <div>
      {/* <button onClick={fetchStudents}>Fetch Details</button> */}
      {/* <button onClick={createStudents}>Create Student</button> */}
      {/* <button onClick={get}>GetDetails</button> */}
    </div>
  );
};

export default Student;
