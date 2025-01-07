import React from "react";


function GetDetails()
{
    return {
        id: prompt("Enter Id"),
        name: prompt("Enter name"),
        title: prompt("Enter title"),
        author: prompt("Enter a Author"),
        name:prompt("Enter a director"),
        name1:prompt("Enter a screenpaly"),
        name2:prompt("Enter a BasedOn"),
        name3:prompt("Enter a Producer")
    }
}
export default GetDetails;