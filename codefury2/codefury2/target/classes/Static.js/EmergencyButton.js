function sendWeatherNotifications() {
    fetch('/api/notifications/sendNow', {
        method: 'POST'
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById('response').innerText = data;
    })
    .catch(error => {
        document.getElementById('response').innerText = 'Error sending notifications';
        console.error('Error:', error);
    });
}
