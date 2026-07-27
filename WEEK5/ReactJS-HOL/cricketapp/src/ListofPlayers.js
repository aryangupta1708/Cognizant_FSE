function ListofPlayers() {

    const players = [

        { name: "Virat", score: 95 },
        { name: "Rohit", score: 82 },
        { name: "Gill", score: 64 },
        { name: "Rahul", score: 72 },
        { name: "Pant", score: 55 },
        { name: "Hardik", score: 88 },
        { name: "Jadeja", score: 69 },
        { name: "Ashwin", score: 91 },
        { name: "Shami", score: 48 },
        { name: "Bumrah", score: 79 },
        { name: "Siraj", score: 67 }

    ];

    return (

        <div>

            <h1>List of Players</h1>

            {

                players.map((player, index) => (

                    <p key={index}>

                        {player.name} - {player.score}

                    </p>

                ))

            }

            <hr />

            <h2>Players with Score below 70</h2>

            {

                players

                    .filter(player => player.score < 70)

                    .map((player, index) => (

                        <p key={index}>

                            {player.name} - {player.score}

                        </p>

                    ))

            }

        </div>

    );

}

export default ListofPlayers;