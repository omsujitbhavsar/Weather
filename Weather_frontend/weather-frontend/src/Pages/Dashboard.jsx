import { useState } from "react";
import { getWeather } from "../services/WeatherService";
import "../styles/Dashboard.css";

function Dashboard() {

    const [city, setCity] = useState("");

    const [weather, setWeather] = useState(null);

    const searchWeather = async () => {

        if (city.trim() === "") {
            alert("Enter City Name");
            return;
        }

        try {

            const response = await getWeather(city);

            setWeather(response.data);

        } catch (error) {

            console.error(error);

            alert("City not found");

        }

    };

    return (

        <div className="dashboard">

            <h1>Weather Dashboard</h1>

            <div className="search-box">

                <input
                    type="text"
                    placeholder="Enter City"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                />

                <button onClick={searchWeather}>
                    Search
                </button>

            </div>

            {weather && (

                <div className="weather-card">

                    <h2>{weather.city}</h2>

                    <h3>{weather.temperature} °C</h3>

                    <p>{weather.condition}</p>

                </div>

            )}

        </div>

    );
}

export default Dashboard;