<template>
  <div>
    <!-- <iframe src="../../public/html/loginBackground.html" frameborder="0" class="page-background"></iframe> -->

    <div class="login-box" id="demo">
      <div class="input-content">
        <div class="login_tit">
          <div>
            <i class="tit-bg left"></i>
            博天智慧水务 · 云平台
            <i class="tit-bg right"></i>
          </div>
          <p>cloud&nbsp;&nbsp;&nbsp;&nbsp;compute</p>
        </div>
        <p class="p user_icon">
          <input
            type="text"
            v-model="username"
            placeholder="账号"
            autocomplete="off"
            class="login_txtbx"
          />
        </p>
        <p class="p pwd_icon">
          <input
            type="password"
            v-model="password"
            placeholder="密码"
            autocomplete="off"
            class="login_txtbx"
          />
        </p>

        <div class="signup">
          <a class="gv" href="#" @click="login">登&nbsp;&nbsp;录</a>
          <a class="gv" href="#" @click="clear">清&nbsp;&nbsp;空</a>
        </div>
      </div>

      <div class="canvaszz"></div>
      <canvas id="canvas"></canvas>
    </div>
  </div>
</template>


<script>
import { setCookie } from '@/tools/cookie'
import { login } from '@/api/user'
export default {
  data() {
    return {
      username: '',
      password: '',
      ctx: '',
      stars: [],
      hue: 217,
      w: 1,
      h: 0,
      ctx2: {}
    }
  },
  created() {},
  mounted() {
    this.initcavas()
  },
  methods: {
    login: function() {
      login(this.username, this.password, this.$message)
    },
    clear: function() {
      this.username = ''
      this.password = ''
    },
    initcavas: function() {
      var canvas = document.getElementById('canvas'),
        ctx = canvas.getContext('2d'),
        w = (canvas.width = window.innerWidth),
        h = (canvas.height = window.innerHeight),
        hue = 217,
        stars = [],
        count = 0,
        maxStars = 2500 //星星数量

      var canvas2 = document.createElement('canvas'),
        ctx2 = canvas2.getContext('2d')
      canvas2.width = 100
      canvas2.height = 100
      var half = canvas2.width / 2,
        gradient2 = ctx2.createRadialGradient(half, half, 0, half, half, half)
      gradient2.addColorStop(0.025, '#CCC')
      gradient2.addColorStop(0.1, 'hsl(' + hue + ', 61%, 33%)')
      gradient2.addColorStop(0.25, 'hsl(' + hue + ', 64%, 6%)')
      gradient2.addColorStop(1, 'transparent')

      ctx2.fillStyle = gradient2
      ctx2.beginPath()
      ctx2.arc(half, half, half, 0, Math.PI * 2)
      ctx2.fill()

      // End cache

      function random(min, max) {
        if (arguments.length < 2) {
          max = min
          min = 0
        }

        if (min > max) {
          var hold = max
          max = min
          min = hold
        }

        return Math.floor(Math.random() * (max - min + 1)) + min
      }

      function maxOrbit(x, y) {
        var max = Math.max(x, y),
          diameter = Math.round(Math.sqrt(max * max + max * max))
        return diameter / 2
        //星星移动范围，值越大范围越小，
      }

      var Star = function() {
        this.orbitRadius = random(maxOrbit(w, h))
        this.radius = random(60, this.orbitRadius) / 18
        //星星大小
        this.orbitX = w / 2
        this.orbitY = h / 2
        this.timePassed = random(0, maxStars)
        this.speed = random(this.orbitRadius) / 500000
        //星星移动速度
        this.alpha = random(2, 10) / 10

        count++
        stars[count] = this
      }

      Star.prototype.draw = function() {
        var x = Math.sin(this.timePassed) * this.orbitRadius + this.orbitX,
          y = Math.cos(this.timePassed) * this.orbitRadius + this.orbitY,
          twinkle = random(10)

        if (twinkle === 1 && this.alpha > 0) {
          this.alpha -= 0.05
        } else if (twinkle === 2 && this.alpha < 1) {
          this.alpha += 0.05
        }

        ctx.globalAlpha = this.alpha
        ctx.drawImage(
          canvas2,
          x - this.radius / 2,
          y - this.radius / 2,
          this.radius,
          this.radius
        )
        this.timePassed += this.speed
      }

      for (var i = 0; i < maxStars; i++) {
        new Star()
      }

      function animation() {
        ctx.globalCompositeOperation = 'source-over'
        ctx.globalAlpha = 0.5 //尾巴
        ctx.fillStyle = 'hsla(' + hue + ', 64%, 6%, 2)'
        ctx.fillRect(0, 0, w, h)

        ctx.globalCompositeOperation = 'lighter'
        for (var i = 1, l = stars.length; i < l; i++) {
          stars[i].draw()
        }

        window.requestAnimationFrame(animation)
      }

      animation()
    }
  }
}
</script>

<style scoped>
.J_codeimg {
  z-index: -1;
  position: absolute;
}
.page-background {
  width: 100%;
  height: 700px;
}
.page {
  background-image: url('../images/loginbgimages.jpg');
  background-repeat: no-repeat;
  background-size: 100% auto;
}
#login-box {
  width: 50%;
  height: 20rem;
  position: fixed;
  top: 100px;
  margin: 0 auto;
  margin-top: 10%;
  text-align: center;
  background: #00000060;

  padding: 20px 50px;
}
#login-box h1 {
  color: #fff;
  font-size: 1rem;
  margin-top: 1rem;
}
#login-box .form .item {
  margin-top: 1rem;
}
#login-box .form .item i {
  color: #fff;
}
#login-box .form .item input {
  width: 60%;
  height: 3rem;
  font-size: 18px;
  border: 50px;
  border-bottom: 2px solid #fff;
  padding: 5px 10px;
  background: #00ffff00;
  color: #fff;
}
#login-box button {
  margin-top: 2rem;
  width: 60%;
  height: 3rem;
  font-size: 20px;
  font-weight: 100;
  color: #fff;
  background-image: linear-gradient(to right, #db3125 0%, #578bc3 100%);
  border: 0;
  border-radius: 15rem;
}
.username {
  border-radius: 1rem;
}
.password {
  border-radius: 1rem;
}

#erro {
  position: relative;
  top: 30px;
  color: red;
  font-size: large;
  display: inline-block;
}
.login-box {
  position: fixed;
  width: 100%;
}
.login-box .signup {
  display: flex;
  width: 100%;
  margin-top: 40px;
  text-align: center;
}
.input-content {
  position: absolute;
  z-index: 9999;
  padding: 30px;
  width: 350px;
  left: 50%;
  margin-left: -205px;
  top: 25%;
  width: 400px;
}
.input-content .p:before {
  font-family: 'adminthemesregular';
  position: absolute;
  top: -9px;
  left: 35px;
  height: 42px;
  line-height: 42px;
  font-size: 20px;
  color: #fff;
}
.input-content .p {
  display: flex;
  justify-content: center;
  margin: 10px 0;
  height: 44px;
  position: relative;
}
</style>
