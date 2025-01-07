import React from "react";
import './contact.css'
function Contact()
{
    return(
        <div className="conatct1">
                <h1>contacts Us</h1>
            <div className="contact">
                <br />
                 <img src="https://images.pexels.com/photos/225232/pexels-photo-225232.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"></img>
            </div>
            <div>
                <h1>Comments</h1>
                {/* <img src="https://media.istockphoto.com/id/1141778521/vector/mobile-phone-vibrating-or-ringing-flat-vector-icon-for-apps-and-websites.jpg?s=612x612&w=0&k=20&c=DdQVkRexW_o2b86c4yqz24UpNpUA0IIVTS2_tFXECjo="></img> */}
                <h6>A Contact Us page is a section on a website dedicated to allowing that site's audience – be they existing clients, potential customers, or simply interested parties – to contact the business. A Contact Us page typically includes the business': Email address. Phone number.</h6>
            </div>
            <br />
            <div>
                <h1>Help</h1>
                <h6>Of course! I'm here to help. Please let me know what you need assistance with or what questions you have.</h6>
                <br />
                <h6>As a rule, the best contact pages perform certain functions: They explain why a visitor should contact you and describe how you can help to solve your visitors' problems. They include an email and phone number so that the visitors could quickly find the required information</h6>
            </div>
            <br />
            <div>
                <h2>Contact us</h2>
                <h6>@1/146,Anjaneyar kovil street,Periyasevalai</h6>
                <h6> Ulunderpet,Kallakurichi</h6>
                <h6>Phone:9843249607,6380087037</h6>
                <h6>Email:manikannan6380@gmail.com</h6>
                
            </div>
            <br />
            <br />
            <div className="p">
                <img className="pii" src="https://cdn.pixabay.com/photo/2016/12/15/12/24/contact-us-1908762_640.png" id="pui"></img>
            </div>
        </div>
    )
}
export default Contact;