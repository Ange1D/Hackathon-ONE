import React from "react";
import "./home.css";

const Home = () => {

    return (
        <div>
            <div className="hero">
                <img className="hero-bg" src="./images/hero-bg-top.png" alt="hero top background" />
                <div className="hero-front">
                    <h3>
                        Looking<br/>for a<br/>team?
                    </h3>
                    <button>
                        Sign up &<br/>play
                    </button>
                </div>
            </div>
            <div className="section1">
                <img src="./images/section1-img.png" alt="league-of-legends-image" />
                <div>
                    <h3>
                        BUILT FOR NOOBS AND<br/>PROS
                    </h3>
                    <p>Leeroy is made for players of all skill levels</p>
                </div>
                
            </div>
            <div className="section2">
                <img src="./images/section2-img.png" alt="league-of-legends-rift" />
                <h3>LOOKUP ANYONE</h3>
                <input type="text" placeholder="Search"/>
                <p>Have fun in your next conquest, and please Don’t act as Leeroy Jenkings!!</p>
            </div>
        </div>
    )
}

export default Home;