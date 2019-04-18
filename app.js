App({
  globalData: {
    isIphoneX: false,
    userInfo: null,
    urlPath: "https://myserver.com",
    about: '此项目长期维护，如果有需要的可以在github自行下载，感觉还不错可以给作者star',
    openid: undefined,
    appid: 'wx11b17040118611a9',
    secret: '26a9537756d7f125244e021b312afb19'
  },
  onShow: function() {
    let that = this;
    wx.getSystemInfo({
      success: res => {
        // console.log('手机信息res'+res.model)
        let modelmes = res.model;
        if (modelmes.search('iPhone X') != -1) {
          that.globalData.isIphoneX = true
        }

      }
    })
  },
  onLaunch: function() {
    // 展示本地存储能力
    var that = this
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: function(res) {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
          var code = res.code;
          console.log(code);
          wx.request({
            url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + that.globalData.appid + '&secret=' + that.globalData.secret + '&js_code=' + code + '&grant_type=authorization_code',
            data: {},
            method: 'GET',
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: function(res) {
              that.globalData.openid = res.data.openid
              // console.log('that.globalData.openid为' + that.globalData.openid + 'openid为' + res.data.openid);
            }
          });
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              console.log(res.userInfo);
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        } else {
          wx.reLaunch({
            url: '/pages/translation/index',
          })
        }
      }
    })
  }
});