let webSocket = null;
let box = null;
let redInput = null;
let greenInput = null;
let blueInput = null;
let RGBJson = null;
let isFirstCall = true;

function connect() {
	webSocket = new WebSocket('ws://localhost:8080/rgb');

	webSocket.onopen = function() {
		console.log('Connected');
		webSocket.send('');
	};

	webSocket.onmessage = function(event) {
		console.log(event.data);
		RGBJson = JSON.parse(event.data);
		box.style.backgroundColor = ["rgb(",RGBJson.red,",",RGBJson.green,",",RGBJson.blue,")"].join("")

		if (isFirstCall) {
			isFirstCall = false;
			redInput.value = RGBJson.red;
			greenInput.value = RGBJson.green;
			blueInput.value = RGBJson.blue;
		}
	};

	webSocket.onclose = function(event) {
		console.log('Closing Connection');
	};
}

function changeColor() {
	if (webSocket != null) {
		webSocket.send(JSON.stringify({"red": redInput.value, "green": greenInput.value, "blue": blueInput.value}));
	} else {
		alert('Connection not established.');
	}
}

document.addEventListener("DOMContentLoaded", () => {
	box = document.getElementById('box');
	redInput = document.getElementById('red-input');
	greenInput = document.getElementById('green-input');
	blueInput = document.getElementById('blue-input');
	connect();
});