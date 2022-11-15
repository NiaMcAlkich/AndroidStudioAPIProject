# SH Group Weather App!!!
## _A collective effort from the SH Android class of 2022_

[![N|Solid](https://www.southhills.edu/wp-content/uploads/2015/07/SouthHillsWebRetina.jpg)](https://nodesource.com/products/nsolid)


## What is this?

- A custom weather application using the https://www.weatherbit.io/ API
- Using GitFlow to manage multiple contributors and changes
- For many an introduction to a multi-developer project!


## Tech

Using Kotlin based Android Development:

- All source data is coming from https://www.weatherbit.io/



## Installation

TBD



## API Documentation

https://www.weatherbit.io/api

Current Weather Data returned using:
https://www.weatherbit.io/api/swaggerui/weather-api-v2#!/Current32Weather32Data/get_current_lat_lat_lon_lon

Weather API Codes/Icons:
https://www.weatherbit.io/api/codes

Sample of returned JSON data on Current Weather Call:
```json
{
  "count": "1",
  "data": [
    {
      "city_name": "Raleigh",
      "state_code": "NC",
      "country_code": "US",
      "timezone": "America/New_York",
      "lat": 38,
      "lon": -78.25,
      "station": "KRDU",
      "sources": [
        "rtma"
      ],
      "vis": 10000,
      "rh": 75,
      "dewpt": 12,
      "wind_dir": 125,
      "wind_cdir": "ENE",
      "wind_cdir_full": "East-North-East",
      "wind_speed": 5.85,
      "temp": 13.85,
      "app_temp": 14.85,
      "clouds": 42,
      "weather": {
        "icon": "c02",
        "code": "802",
        "description": "Broken clouds"
      },
      "datetime": "2017-03-15:13",
      "ob_time": "2017-03-15 13:11",
      "ts": 1490990400,
      "sunrise": "06:22",
      "sunset": "19:34",
      "slp": 1013.12,
      "pres": 1010,
      "aqi": 50,
      "uv": 6.5,
      "solar_rad": 300.4,
      "ghi": 450.4,
      "dni": 450.4,
      "dhi": 450.4,
      "elev_angle": 37,
      "hour_angle": 45,
      "pod": "string",
      "precip": 2,
      "snow": 10
    }
  ]
}