let stompClient = null;
let box = null;
let redInput = null;
let greenInput = null;
let blueInput = null;
let RGBJson = null;
let isFirstCall = true;

function connect() {
	stompClient = Stomp.client('ws://localhost:8080/rgb');
	stompClient.connect({}, (frame) => {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/rgb', function(messageOutput) {
			RGBJson = JSON.parse(messageOutput.body);
			box.style.backgroundColor = ["rgb(",RGBJson.red,",",RGBJson.green,",",RGBJson.blue,")"].join("")

			if (isFirstCall) {
				isFirstCall = false;
				redInput.value = RGBJson.red;
				greenInput.value = RGBJson.green;
				blueInput.value = RGBJson.blue;
			}
		});
		stompClient.send("/app/rgb-initial");
	},
	(err) => {
		console.log('Connected: ' + err);
	});
}

function disconnect() {
	if(stompClient != null) {
		stompClient.disconnect();
	}
	console.log("Disconnected");
}

function sendRGBMessage() {
	stompClient.send("/app/rgb", {},
		JSON.stringify({"red": redInput.value, "green": greenInput.value, "blue": blueInput.value}));
}

function showMessageOutput(messageOutput) {
	var response = document.getElementById('response');
	var p = document.createElement('p');
	p.style.wordWrap = 'break-word';
	p.appendChild(document.createTextNode(messageOutput.from + ": "
		+ messageOutput.text + " (" + messageOutput.time + ")"));
	response.appendChild(p);
}

function changeColor() {
	sendRGBMessage();
}

document.addEventListener("DOMContentLoaded", () => {
	box = document.getElementById('box');
	redInput = document.getElementById('red-input');
	greenInput = document.getElementById('green-input');
	blueInput = document.getElementById('blue-input');
	disconnect();
	connect();
});