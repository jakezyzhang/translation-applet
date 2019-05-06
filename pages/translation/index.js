const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    multiArray: [
      ['中', '英', '法', '日', '韩', 'AI'],
      ['中', '英', '法', '日', '韩']
    ],
    multiIndex: [0, 0],
    active: 0,
    show: {
      middle: false
    },
    transResult: '',
    isHide: 'none',
    chatView: '',
    list: [],
    scrollHeight: 0,
    transSrc: undefined,
    transDst: undefined,
    kquery: undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log(options.active);
    let isIphoneX = app.globalData.isIphoneX;
    this.setData({
      isIphoneX: isIphoneX,
      active: options.active
    })
    this.computeScrollViewHeight()

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  toggle(type) {
    this.setData({
      [`show.${type}`]: !this.data.show[type]
    });
  },
  onClickIcon() {
    this.toggle('middle');
  },
  bindMultiPickerChange(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      multiIndex: e.detail.value
    })
  },
  bindMultiPickerColumnChange(e) {
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value)
    const data = {
      multiArray: this.data.multiArray,
      multiIndex: this.data.multiIndex
    }
    data.multiIndex[e.detail.column] = e.detail.value
    data.multiArray[1] = ['中', '英', '法', '日', '韩']
    console.log('第一列:' + data.multiIndex[0] + '第二列:' + data.multiIndex[1])
    console.log(data)
    this.setData(data)
  },
  onChange(event) {
    console.log(event.detail);
    if (event.detail == 0) {
      wx.redirectTo({
        url: '../translation/index?active=' + event.detail,
      })
    }
    if (event.detail == 1) {
      wx.redirectTo({
        url: '../news/news?active=' + event.detail,
      })

    }
    if (event.detail == 2) {
      wx.redirectTo({
        url: '../person/person?active=' + event.detail,
      })
    }
  },
  openAlert: function() {
    wx.showModal({
      content: '弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内',
      showCancel: false,
      success: function(res) {
        if (res.confirm) {
          console.log('用户点击确定')
        }
      }
    });
  },
  formSubmit(e) {
    var that = this
    var kword = that.trim(e.detail.value.word)
    that.data.kquery = kword
    console.log(kword)
    console.log('form发生了submit事件，携带数据为：', e.detail.value.word + that.data.multiIndex[0])
    if (kword == '') {
      console.log("run here")
      return;
    }
    wx.request({
      url: app.globalData.urlPath + '/Word/translation',
      data: {
        query: kword,
        fromWord: that.data.multiIndex[0],
        toWord: that.data.multiIndex[1]
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        console.log(res.data.src)
        that.data.list.push(res.data)
        that.setData({
          list: that.data.list,
        })
        wx.request({
          url: app.globalData.urlPath + '/Word/addword',
          data: {
            query: that.data.kquery,
            fromWord: that.data.multiIndex[0],
            toWord: that.data.multiIndex[1],
            transSrc: res.data.src,
            transDst: res.data.dst
          },
          method: 'POST',
          header: {
            'content-type': 'application/x-www-form-urlencoded',
            'Cookie': 'JSESSIONID=' + app.globalData.sessionid
          },
          success: function (res) {
            console.log(res.data)
          }
        });
      }
    });
  },
  trim: function(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
  },
  computeScrollViewHeight() {
    var that = this
    var query = wx.createSelectorQuery()
    query.select('#word').boundingClientRect()
    query.select('#transBtn').boundingClientRect()
    query.exec(res => {
      var searchHeight = res[0].height
      var bottonHeight = res[1].height
      var windowHeight = wx.getSystemInfoSync().windowHeight
      var scrollHeight = windowHeight - searchHeight - bottonHeight - 50 - 50 - 50
      console.log(scrollHeight)
      that.setData({
        scrollHeight: scrollHeight
      })
    })
  },
})