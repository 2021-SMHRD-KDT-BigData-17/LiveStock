class Schedule {

    constructor(name, description, date, time){

    }

}

const ls = localStorage;

// Calander main
const Calendar = {

    init(){
        const today = new Date();
        Calendar.showDates(today.getFullYear(), today.getMonth() +1);
    
        Calendar.year = today.getFullYear();
        Calendar.month = today.getMonth() +1;

  
    },


    evtHandle(){
        document.querySelectorAll(".date")
            .forEach(elem => {
                elem.onclick = function(){
                    document.querySelector(".modal.schedule")
                        .classList.add("show");


                    const day = Calendar.day = this.innerText;
                    const $mTitle = document.querySelector(".modal.schedule .modal-title");  
                    $mTitle.innerHTML = `${Calendar.month}월  ${day}일  일정`;
                   
                    Calendar.refreshScheduleList();
                }   
            });

    },

    refreshScheduleList(){
        const $mScheduleList = document.querySelector(".modal.schedule.schedule-list");
        const schedules = ScheduleManager.Schedules
           .filter(v => v.date == `${Calendar.year}-${Calendar.month}-${Calendar.day}`);

        if (schedules.length)
           $mScheduleList.innerHTML = schedules.map(sc => `
               <div class="schedule flex aic jcsb">
                   <h3>${sc.title}</h3>
                   <button onclick="ScheduleManager.remove('${sc.id}')></button>
                   
               </div>
           `).join("\n\n");
    }, 

    showDates(y, m){
        const before = document.querySelectorAll(".date");
        before.forEach(v => v.remove());

        for (
            let i = -Calendar.getFirstDay(y, m) + 1;
            i <= Calendar.getLastdate(y, m);
            i++
        ){
            Calendar.$calendar.innerHTML += `
                <div class="date ${i < 1 ? "hidden-date" : ""}">
                    <p>${i}</p>
                </div>
            `;
        }        
        Calendar.evtHandle();

    },

    getFirstDay(y, m){
        const date = new Date(`${y}-${m}-01` );
        return date.getDay();
    },
    getLastdate(y, m) {
        const date = new Date(y, m, 0);
        return date.getDate();

    },

    addMonth(m) {
        const date = new Date(
            Calendar.year, Calendar.month + m - 1, 1
        );
        Calendar.year = date.getFullYear();
        Calendar.month = date.getMonth() + 1;

        Calendar.showDates(Calendar.year, Calendar.month);
        Calendar.$date.innerHTML = `${Calendar.year}.${Calendar.month}.`

    }

};

const ScheduleManager = {

    Schedules: [],

    loadSchedule(){
        if (!ls['schedules']) return;

        ScheduleManager.Schedules =
            JSON.parse(ls['schedules']);
    },

    saveSchedule(){
        ls['schedules'] =
            JSON.stringify(ScheduleManager.schedules);
    },

    addSchedule(){
        const title = prompt("어떤 일정을 추가하시겠습니까?");
        
        if (!title.match(/^[a-zA-Z0-9ㄱ-힣]*$/g))
            return alert("어잉");

        const id = new Date().getTime();
        this.schedules.push({
            id,
            date: `${Calendar.year}-${Calendar.month}-${Calendar.day}`,
            title
        });

        this.saveSchedule();
        Calendar.refreshScheduleList();
    }

}

const btn = document.getElementById('popupBtn');
const modal = document.getElementById('modalWrap');
const closeBtn = document.getElementById('closeBtn');

btn.onclick = function() {
  modal.style.display = 'block';
}
closeBtn.onclick = function() {
  modal.style.display = 'none';
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}