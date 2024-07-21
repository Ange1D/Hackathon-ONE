import "./teamCreated.css"

const TeamCreated = () =>{
    return(
        <div className="teamCreated">
            <div className="teamCreatedTitle">
            <img src="./images/splashart-lol2.png" alt="Splashart-lol2" />
                <h2>YOUR TEAM</h2>
            </div>
            <div className="teamCreatedInfo">

                <img src="./images/lol-Logo.png" className="logo" alt="league of legends logo" />
                <img src="./images/rectangle10.png" className="back-logo" alt="team created background" />
                <div className="teamInfo">
                    <h2>TEAM'S NAME</h2>
                    
                    <h3>MEMBERS</h3>
                    
                    <ul>
                        <li>member x</li>
                    </ul>
                    
                    <h3>COUNTRY</h3>
                </div>
                <button type="submit">CREATE NEW TEAM</button>
            </div>
        </div>
    )
}

export default TeamCreated;