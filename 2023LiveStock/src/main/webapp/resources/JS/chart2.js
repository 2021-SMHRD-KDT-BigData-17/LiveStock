
new Chart(document.getElementById('pie'), {
  type: 'pie',
  data: {
    labels: ['소', '닭', '돼지', '오리'],
    datasets: [{
      label: '# of Votes',
      backgroundColor : ["#00ccff","#1d3557","#254BDD","#ccffff"],
      data: [12, 19, 3, 4],
      borderWidth : 2,
    }]
  },
  options: {
    title : {
      display : true,
        text: "pie"
    },
    reponsive : false,
  }

});