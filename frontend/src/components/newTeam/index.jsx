import "./newTeam.css"

const NewTeam = () =>{
    return(
        <div className="yourTeam">
            <div className="yourTeamTitle">
            <img src="./images/splashart-lol2.png" alt="Splashart-lol2" />
                <h2>YOUR TEAM</h2>
            </div>
            <div className="yourTeamInfo">
                <h3>NAME</h3>
                <input type="text" required/>
                <h3>GAME</h3>
                <input type="text" required/>
                <h3>COUNTRY</h3>
                <input type="text" required/>
                <h3>INITIALS</h3>
                <input type="text" required/>
                <button type="submit">CREATE</button>
            </div>
        </div>
    )
}

export default NewTeam; 