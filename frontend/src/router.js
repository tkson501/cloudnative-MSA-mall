
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import ProductSearchView from "./components/ProductSearchView"
import ProductSearchViewDetail from "./components/ProductSearchViewDetail"
import OrderHistoryView from "./components/OrderHistoryView"
import OrderHistoryViewDetail from "./components/OrderHistoryViewDetail"
import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import InventoryManager from "./components/listers/InventoryCards"
import InventoryDetail from "./components/listers/InventoryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/productSearches',
                name: 'ProductSearchView',
                component: ProductSearchView
            },
            {
                path: '/productSearches/:id',
                name: 'ProductSearchViewDetail',
                component: ProductSearchViewDetail
            },
            {
                path: '/orderHistories',
                name: 'OrderHistoryView',
                component: OrderHistoryView
            },
            {
                path: '/orderHistories/:id',
                name: 'OrderHistoryViewDetail',
                component: OrderHistoryViewDetail
            },
            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },
            {
                path: '/inventories/:id',
                name: 'InventoryDetail',
                component: InventoryDetail
            },



    ]
})
