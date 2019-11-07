var game;

			function display(game) {
				console.log(game);

				$(".columnOfCards .cardLocation").html("");

				$.each(game.cols[0], function(key, val) {
					$("#c0 .l" + key).html(val.value + val.suit);
				});

				$.each(game.cols[1], function(key, val) {
					$("#c1 .l" + key).html( val.suit + val.suit);
				});

				$.each(game.cols[2], function(key, val) {
					$("#c2 .l" + key).html(val.value + val.suit);
				});

				$.each(game.cols[3], function(key, val) {
					$("#c3 .l" + key).html(val.value + val.suit);
				});
			}

			// Calls ApplicationController.gameGet()
			$.getJSON("http://localhost:8080/game", function(data) {
				display(data);
				game = data;
			});

			$("#dealButton").click(function() {
				$.ajax({
					type: "POST",
					url: "/dealGame",
					data: JSON.stringify(game),
					success: function(data, status) {
						console.log("Data: " + data + "\nStatus: " + status);
						game = data;
						display(data);
					},
					contentType: "application/json; charset=utf-8",
					dataType: "json"
				});
			});

			function removeCard(colNumber) {
				$.ajax({
					type: "POST",
					url: "/removeCard/" + colNumber,
					data: JSON.stringify(game),
					success: function(data, status) {
						console.log("Data: " + data + "\nStatus: " + status);
						game = data;
						display(data);
					},
					contentType: "application/json; charset=utf-8",
					dataType: "json"
				});
			}

			$("#Remove1").click(function() {
				removeCard(0);
			});
			$("#Remove2").click(function() {
				removeCard(1);
			});
			$("#Remove3").click(function() {
				removeCard(2);
			});
			$("#Remove4").click(function() {
				removeCard(3);
			});

			$("#moveButton").click(function() {
				var colFrom = $("#from_col").val();
				var colTo = $("#to_col").val();
				$.ajax({
					type: "POST",
					url: "/moveCard/" + colFrom + "/" + colTo,
					data: JSON.stringify(game),
					success: function(data, status) {
						console.log("Data: " + data + "\nStatus: " + status);
						game = data;
						display(data);
					},
					contentType: "application/json; charset=utf-8",
					dataType: "json"
				});
			});