import './teamDetails.css'

const TeamDetails = () =>{
    return(
        <div className='teamDetails'>
            <div className="teamDetailsTitle">
                <img src="./images/splashart-lol2.png" alt="Splashart-lol2" />
                <h2>TEAM DETAILS</h2>
            </div>
            <div className='teamDetailsInfo'>
                <div className='teamAbout'>
                    <h3>ABOUT</h3>
                    <p>We dont know much about this team yet, 
                        but we are sure they are a great team!</p>
                </div>
                <div className='avgRank'>
                    <h3>AVG. TEAM RANK</h3>
                    <img src="./images/rank-default.png" alt="rank-default" />
                    <h4>UNRANKED</h4>
                </div>
                <div className='teamMembers'>
                    <h3>TEAM MEMBERS</h3>
                    <ul>
                        <li>
                            <h4>ADMIN</h4>
                            <div>
                                <img src="" alt="" />
                                <h5>User name</h5>
                            </div>
                            <div>
                                <img src="" alt="" />
                                <h5>ALL</h5>
                            </div>
                            <button>VIEW PROFILE</button>
                        </li>
                    </ul>
                </div>
            </div>
            <button>DELETE TEAM</button>
        </div>
    )
}

export default TeamDetails;