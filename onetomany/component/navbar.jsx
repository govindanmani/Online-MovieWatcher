import React from "react";
import "./navbar.css";
import { Link } from "react-router-dom";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  BrowserRouter,
} from "react-router-dom";
import Romance from "./romance";
import Use from "./home";
import Comedy from "./comedy";
import Anime from "./animation";
import Sciencs from "./science";
import Thriller from "./theriller";
import Mistry from "./mistry";
import Adventure from "./adventure";
import Fantasy from "./fantsy";
import AddFunction5 from "./login";
import AddFunction1 from "./registration";
import Homepage from "./home1";
import About from "./about";
import Events from "./events";
import Horor from "./horor";
import AboutAddd from "./news";
import Privacy from "./privacy";
import FoterDiss from "./footer";
import Contact from "./contact";
import Profile from "./profile";
import Card from "./card";
import CardComedy from "./cardcomedy";
import Animationcard from "./animationcard";
import Fantsycard from "./fantsycard";
import Actioncard from "./homecard";
import Hororcard from "./hororcard";
import Mistrycard from "./mistrycard";
import Romancecard from "./romancecard";
import Sciencscard from "./sciencecard";
import Therillercard from "./therillercard";
import CardItem from "./cardItem";
// import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function Navbar() {
  return (
    <BrowserRouter>
      <div>
        <div className="cont">
          <ul className="list">
            <div className="child">
              <li>
                <Link to="/" className="kk">
                  <h3>Home</h3>
                </Link>
              </li>

              <li>
                <Link to="/action" className="kk">
                  <h3>Action</h3>
                </Link>
              </li>
              <li>
                <Link to="/horor" className="kk">
                  <h3>Horor</h3>
                </Link>
              </li>
              <li>
                <Link to="/romance" className="kk">
                  <h3>Romance</h3>
                </Link>
              </li>
              <li>
                <Link to="/comedy" className="kk">
                  <h3>Comedy</h3>
                </Link>
              </li>
              <li>
                <Link to="/animation" className="kk">
                  <h3>Animation</h3>
                </Link>
              </li>
              <li>
                <Link to="/Scitenfic" className="kk">
                  <h3>Scitenfic</h3>
                </Link>
              </li>
              <li>
                <Link to="/thriller" className="kk">
                  <h3>thriller</h3>
                </Link>
              </li>
              <li>
                <Link to="/mistry" className="kk">
                  <h3>Mistry</h3>
                </Link>
              </li>
              <li>
                <Link to="/adventure" className="kk">
                  <h3>Adventure</h3>
                </Link>
              </li>
              <li>
                <Link to="/fantsy" className="kk">
                  <h3>Fantasy</h3>
                </Link>
              </li>
              <li>
                <Link to="/login" className="kk">
                  <h3>Login</h3>
                </Link>
              </li>
              {/* <li>
                    <Link to="/register" className="kk"><h3>Registration</h3></Link>
                    </li> */}

              <li>
                <Link to="/profile">
                  <i className="fa-solid fa-user"></i>
                </Link>
                <Link to="/Carditem">
                  <i class="fa-solid fa-cart-shopping"></i>
                  <h2></h2>
                </Link>
                {/* <AccountCircleIcon /> */}
              </li>
            </div>
          </ul>
        </div>

        <Routes>
          <Route exact path="/" element={<Homepage />} />

          <Route exact path="/action" element={<Use />} />
          <Route exact path="/horor" element={<Horor />} />
          <Route exact path="/romance" element={<Romance />} />
          <Route exact path="/comedy" element={<Comedy />} />
          <Route exact path="/animation" element={<Anime />} />
          <Route exact path="/Scitenfic" element={<Sciencs />} />
          <Route exact path="/thriller" element={<Thriller />} />
          <Route exact path="/thriller/:id" element={<Thriller />} />
          <Route exact path="/mistry" element={<Mistry />} />
          <Route exact path="/adventure" element={<Adventure />} />
          <Route exact path="/fantsy" element={<Fantasy />} />
          <Route exact path="/login" element={<AddFunction5 />} />
          <Route exact path="/register" element={<AddFunction1 />} />
          <Route exact path="/about" element={<About />} />
          <Route exact path="/events" element={<Events />} />
          <Route exact path="/news" element={<AboutAddd />} />
          <Route exact path="/privacy" element={<Privacy />} />
          <Route exact path="/contact" element={<Contact />} />
          {/* <Route exact path="/Card"   element={<Card />} /> */}

          <Route
            exact
            path="/Card/:idvalue"
            Component={Card}
            element={<Card />}
          />
          <Route exact path="/profile" element={<Profile />} />
          <Route
            exact
            path="/Cardcomedy/:idvalue"
            Component={CardComedy}
            element={<CardComedy />}
          />
          <Route
            exact
            path="/Cardanimation/:idvalue"
            Component={Animationcard}
            element={<Animationcard />}
          />
          <Route
            exact
            path="/Cardfansty/:idvalue"
            Component={Fantsycard}
            element={<Fantsycard />}
          />
          <Route
            exact
            path="/CardAction/:idvalue"
            Component={Actioncard}
            element={<Actioncard />}
          />
          <Route
            exact
            path="/CardHoror/:idvalue"
            Component={Hororcard}
            element={<Hororcard />}
          />
          <Route
            exact
            path="/CardMistry/:idvalue"
            Component={Mistrycard}
            element={<Mistrycard />}
          />
          <Route
            exact
            path="/CardRomance/:idvalue"
            Component={Romancecard}
            element={<Romancecard />}
          />
          <Route
            exact
            path="/CardScience/:idvalue"
            Component={Sciencscard}
            element={<Sciencscard />}
          />
          <Route
            exact
            path="/CardTheriller/:idvalue"
            Component={Therillercard}
            element={<Therillercard />}
          />
          <Route
            exact
            path="/CardItem/:idvalue"
            Component={CardItem}
            element={<CardItem />}
          />
          <Route exact path="/Carditem" element={<CardItem />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}
export default Navbar;
