
// Current Date
function showDateTime() {
    const datetime = document.getElementById("datetime");
  
    const now = new Date();
  
    const daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    const dayOfWeek = daysOfWeek[now.getDay()];
  
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    const year = now.getFullYear();
  
    datetime.innerHTML = `${dayOfWeek},${month}/${day}/${year}`;
  }

showDateTime();
setInterval(showDateTime, 1000);

// Weather Widget
const locationSelect = document.getElementById('location-select');
const countryElement = document.getElementById('country');
const temperatureElement = document.getElementById('temperature');
const conditionElement = document.getElementById('condition');
const iconElement = document.getElementById('icon');
let isCelsius = true;

// Fetch weather data 
function fetchWeatherData(location) {
  const apiKey = '72b4af94d7814fd695290322241101';
  const endpointUrl = `http://api.weatherapi.com/v1/current.json?key=${apiKey}&q=${location}&aqi=yes`;
 
  fetch(endpointUrl)
    .then(response => response.json())
    .then(data => {
      const { location, current } = data;

      countryElement.textContent = location.country;
      temperatureElement.textContent = `${current.temp_c}°C`;
      conditionElement.textContent = current.condition.text;
      iconElement.src = `https:${current.condition.icon}`;
      iconElement.alt = current.condition.text;
    })
    .catch(error => {
      console.log('Error fetching weather data:', error);
    });
}

// Geolocation
function autoDetectLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(position => {
      const latitude = position.coords.latitude;
      const longitude = position.coords.longitude;
      const location = `${latitude},${longitude}`;
      fetchWeatherData(location);
    }, error => {
      console.log('Error getting current position:', error);
    });
  } else {
    console.log('Geolocation is not supported by this browser.');
  }
}

// Location select
locationSelect.addEventListener('change', () => {
  const selectedLocation = locationSelect.value;

  if (selectedLocation === 'auto') {
    autoDetectLocation();
  } else {
    fetchWeatherData(selectedLocation);
  } 
});

// Temp Format change on click
temperatureElement.addEventListener('click',  () => {
  const temperature = parseFloat(temperatureElement.textContent);

  if (isCelsius) {
    const fahrenheit = (temperature * 9/5) + 32;
    temperatureElement.textContent = `${fahrenheit.toFixed(1)}°F`;
    isCelsius = false;
  } else {
    const celsius = (temperature - 32) * 5/9;
    temperatureElement.textContent = `${celsius.toFixed(1)}°C`;
    isCelsius = true;
  }
});

fetchWeatherData(locationSelect.value);

//By BachCT
