<template>
  <div class="content"
       :style='{"minHeight":"100vh","width":"100%","padding":"30px","background":"url(http://codegen.caihongy.cn/20240320/095a0a9d9da74a8fa6c854b2144c65aa.png) no-repeat center top / cover","height":"auto"}'>
    <!-- notice -->
    <!-- title -->
    <div class="text"
         :style='{"margin":"20px auto","fontSize":"24px","color":" #374254","textAlign":"center","fontWeight":"bold"}'>
      欢迎使用 {{ this.$project.projectName }}
    </div>


    <!-- echarts -->
  </div>
</template>
<script>
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'

export default {
  data() {
    return {};
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      if (this.$storage.get('Token')) {
        this.$http({
          url: `${this.$storage.get('sessionTable')}/session`,
          method: "get"
        }).then(({data}) => {
          if (data && data.code != 0) {
            router.push({name: 'login'})
          }
        });
      } else {
        router.push({name: 'login'})
      }
    },
  }
};
</script>
<style lang="scss" scoped>
.cardView {
  display: flex;
  flex-wrap: wrap;
  width: 100%;

  .cards {
    display: flex;
    align-items: center;
    width: 100%;
    margin-bottom: 10px;
    justify-content: center;

    .card {
      width: calc(25% - 20px);
      margin: 0 10px;

      /deep/ .el-card__body {
        padding: 0;
      }
    }
  }
}

// 日历
.calendar td .text {
  border-radius: 12px;
  flex-direction: column;
  background: #fff;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.calendar td .text:hover {
  background: rgba(78, 110, 242, .1);
}

.calendar td .text .new {
  color: #000;
  font-size: 24px;
  line-height: 1.4;
}

.calendar td .text .old {
  color: #666;
  font-size: 16px;
  line-height: 1.4;
}

.calendar td.festival .text {
  border-radius: 12px;
  flex-direction: column;
  background: rgba(235, 51, 51, .05);
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.calendar td.festival .text:hover {
  background: rgba(78, 110, 242, .1);
}

.calendar td.festival .text .new {
  color: #000;
  font-size: 24px;
  line-height: 1.4;
}

.calendar td.festival .text .old {
  color: #666;
  font-size: 16px;
  line-height: 1.4;
}

.calendar td.other .text {
  border-radius: 12px;
  flex-direction: column;
  background: #fff;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  opacity: 0.3;
  height: 100%;
}

.calendar td.other .text:hover {
  background: rgba(78, 110, 242, .1);
}

.calendar td.other .text .new {
  color: #000;
  font-size: 24px;
  line-height: 1.4;
}

.calendar td.other .text .old {
  color: #666;
  font-size: 16px;
  line-height: 1.4;
}

.calendar td.today .text {
  border-radius: 12px;
  flex-direction: column;
  color: #fff;
  background: #2ddcd3;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.calendar td.today .text:hover {
  background: rgba(64, 158, 255, .5);
}

.calendar td.today .text .new {
  color: inherit;
  font-size: 24px;
  line-height: 1.4;
}

.calendar td.today .text .old {
  color: inherit;
  font-size: 16px;
  line-height: 1.4;
}

// echarts1
.type1 .echarts1 {
  border-radius: 8px;
  padding: 20px;
  margin: 10px 0;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type1 .echarts1:hover {
}

// echarts2
.type2 .echarts1 {
  border-radius: 8px;
  padding: 20px;
  margin: 10px 0;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type2 .echarts1:hover {
}

.type2 .echarts2 {
  border-radius: 8px;
  padding: 20px;
  margin: 10px 0;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type2 .echarts2:hover {
}

// echarts3
.type3 .echarts1 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type3 .echarts1:hover {
}

.type3 .echarts2 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type3 .echarts2:hover {
}

.type3 .echarts3 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type3 .echarts3:hover {
}

// echarts4
.type4 .echarts1 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type4 .echarts1:hover {
}

.type4 .echarts2 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type4 .echarts2:hover {
}

.type4 .echarts3 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type4 .echarts3:hover {
}

.type4 .echarts4 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type4 .echarts4:hover {
}

// echarts5
.type5 .echarts1 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 100%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type5 .echarts1:hover {
}

.type5 .echarts2 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type5 .echarts2:hover {
}

.type5 .echarts3 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type5 .echarts3:hover {
}

.type5 .echarts4 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type5 .echarts4:hover {
}

.type5 .echarts5 {
  border-radius: 8px;
  padding: 20px;
  margin: 0 0 30px;
  background: rgba(255, 255, 255, 1);
  width: 49%;
  position: relative;
  transition: 0.3s;
  height: 400px;
}

.type5 .echarts5:hover {
}

.echarts-flag-2 {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 10px 20px;
  background: rebeccapurple;

  & > div {
    width: 32%;
    height: 300px;
    margin: 10px 0;
    background: rgba(255, 255, 255, .1);
    border-radius: 8px;
    padding: 10px 20px;
  }
}
</style>
