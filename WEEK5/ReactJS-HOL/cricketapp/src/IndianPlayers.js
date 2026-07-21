function IndianPlayers() {

    const players = [
        "Virat",
        "Rohit",
        "Gill",
        "Rahul",
        "Pant",
        "Hardik"
    ];

    const [odd1, even1, odd2, even2, odd3, even3] = players;

    const T20players = [
        "Virat",
        "Rohit",
        "Hardik"
    ];

    const RanjiPlayers = [
        "Pujara",
        "Rahane",
        "Jaiswal"
    ];

    const mergedPlayers = [...T20players, ...RanjiPlayers];

    return (

        <div>

            <h1>Odd Team Players</h1>

            <p>{odd1}</p>
            <p>{odd2}</p>
            <p>{odd3}</p>

            <hr />

            <h1>Even Team Players</h1>

            <p>{even1}</p>
            <p>{even2}</p>
            <p>{even3}</p>

            <hr />

            <h1>Merged Players</h1>

            {

                mergedPlayers.map((player, index) => (

                    <p key={index}>{player}</p>

                ))

            }

        </div>

    );

}

export default IndianPlayers;