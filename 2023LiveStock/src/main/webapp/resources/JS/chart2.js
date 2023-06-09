
new Chart(document.getElementById('pie'), {
  type: 'pie',
  data: {
    labels: ['소(결핵병)', '닭(조류인플루엔자)', '돼지(아프리카돼지열병)', '오리(조류인플루엔자)'],
    datasets: [{
      label: '#',
      backgroundColor : ["#254BDD","#1d3557","#00ccff","#ccffff"],
      data: [29382, 688378, 213,286991],
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