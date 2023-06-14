class Schedule {

    constructor(name, description, date, time){
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
    }
    getFormattedDateTime() {
        return `${this.date} ${this.time}`;
    }
}

const ls = localStorage;

// Calendar main
const Calendar = {

    init(){
        const today = new Date();

        ScheduleManager.loadSchedule();
        Calendar.showDates(today.getFullYear(), today.getMonth() + 1);
    
        Calendar.year = today.getFullYear();
        Calendar.month = today.getMonth() + 1;

  
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
                   <button onclick="ScheduleManager.remove('${sc.id}')">x</button>
                   
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
            const hasSchedule = ScheduleManager.Schedules.some((schedule) => {
                const [scheduleYear, scheduleMonth, scheduleDay] = schedule.date.split('-');
                return scheduleYear === y.toString() && scheduleMonth === m.toString() && scheduleDay === i.toString();
            });

            const hiddenDateClass = i < 1 ? 'hidden-date' : '';
            const hasScheduleClass = hasSchedule ? 'has-schedule' : '';

            Calendar.$calendar.innerHTML += `
                <div class="date ${hiddenDateClass} ${hasScheduleClass}">
                    <p>${i}</p>
                    <div style="width:10px; height:10px;  border-radius:50%; background-color:red; margin:3px;"></div>
                    <div style="width:10px; height:10px;  border-radius:50%; background-color:blue;  margin:3px;"></div>
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
            JSON.stringify(ScheduleManager.Schedules);
    },

    addSchedule(name, description, date, time){
        const schedule = new Schedule(name, description, date, time);
        this.Schedules.push(schedule);
        this.saveSchedule();
        Calendar.refreshScheduleList();
    },

    remove(id){
        const index = ScheduleManager.Schedules
        .findIndex(v => v.id == id);

        ScheduleManager.Schedules
            .splice(index, 1);

        this.saveSchedule();
        Calendar.refreshScheduleList();

    }
}



function categoryChange(e) {
	var good_a = ["바이러스 입자 불활화 백신(조류)", "혈청형 O형과 A형 혼합백신(소)", "돼지파보백신", "돼지위축성비염백신", "돼지대장균백신혼합백신"];
	var good_b = ["구제역", "조류인플루엔자", "아프리카 돼지열병"];
	
	var target = document.getElementById("livestock-select");

	if(e.value == "vaccine") var d = good_a;
	else if(e.value == "infection") var d = good_b;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}	
}
